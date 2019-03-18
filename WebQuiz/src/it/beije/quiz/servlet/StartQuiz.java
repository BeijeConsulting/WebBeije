package it.beije.quiz.servlet;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.bean.Domanda;
import it.beije.bean.Risposta;
import it.beije.utils.Utils;


/**
 * Servlet implementation class StartQuiz
 */
@WebServlet({ "/StartQuiz", "/risposta" })
public class StartQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartQuiz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int corrette = 0;
		float perc = 0;
		if (request.getRequestURI().equals(request.getContextPath()+"/StartQuiz")) {
			LocalTime time = LocalTime.now();
			request.getSession().putValue("time", time);
			
			response.sendRedirect("domanda.jsp?index=0");
		} else {
			//ELABORAZIONE RISPOSTE
			List<Domanda> domande = (List) request.getSession().getValue("elencoDomande");
			if (domande != null) {
				for (Domanda d : domande) {
					boolean corretta = Utils.controllaRisposta(d.getRispostaEsatta(), d.getRispostaUtente());
					
					response.setContentType("text/html");
					response.getWriter().append("DOMANDA " + d.getId() + " : la tua risposta : " + d.getRispostaUtente() + "<br><br>");
					if (corretta) {
						response.getWriter().append("ESATTO!!! &#128578<br>");
						corrette++;
					} else {
						response.getWriter().append("La risposta esatta era " +  d.getRispostaEsatta() + " &#128577<br>");
					}
					
					response.getWriter().append("<br><br>");
				}
				perc = corrette  * 100 / domande.size();
				response.getWriter().append("Numero risposte corrette : " + corrette + "/" + domande.size() + "<br><br>");
				response.getWriter().append("Percentuale risposte corrette : " + perc + " %" + "<br><br>");
				if(perc > 65) {
					response.getWriter().append("<p style=\"color:green; font-size:20px;\"><b>PROMOSSO!!!</b></p>").append("&#128077");
				} else {
					response.getWriter().append("<p style=\"color:red; font-size:20px;\"><b>BOCCIATO! Impegnati e studia di più!</b></p>").append(" &#128545");
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Domanda> domande = (List) request.getSession().getValue("elencoDomande");
		
		if (domande != null) {
			String index = request.getParameter("index");
			String rispostaUtente = "";
			Domanda d = domande.get(Integer.parseInt(index));							//prendo la domanda con l'indice dell'ultima domanda passata
				for(Risposta r : d.getRisposte()) {										//ciclo sull'array di risposte in sessione
					if(request.getParameter(r.getValue()) != null) {				
						rispostaUtente += request.getParameter(r.getValue());			//aggiungo la risposta solo se il get value è diverso da null
					}
				}
			
//			String rispostaUtente = request.getParameter("RispostaUtente");
//			rispostaUtente = rispostaUtente.replace("null", "");
//			System.out.println(rispostaUtente);
			
			int i = 0;
			if (rispostaUtente != null) {
//				rispostaUtente = rispostaUtente.trim().toUpperCase();
				if (index != null) {
					i = Integer.parseInt(index);
					domande.get(i).setRispostaUtente(rispostaUtente);
					//request.getSession().putValue("indice", new Integer(++indice));
				}
			}
			
			response.sendRedirect("domanda.jsp?index=" + ++i);
		} else {
			response.getWriter().append("SESSIONE SCADUTA! RICARICARE LE DOMANDE");
		}
	}

}
