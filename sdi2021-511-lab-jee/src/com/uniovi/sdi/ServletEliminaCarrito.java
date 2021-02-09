package com.uniovi.sdi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletCarito
 */
@WebServlet("/eliminarEnCarrito")
public class ServletEliminaCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEliminaCarrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		HashMap<String, Integer> carrito = (HashMap<String, Integer>) request.getSession().getAttribute("carrito");
//					No	hay	carrito,	creamos	uno	y	lo	insertamos	en	sesión
		if (carrito != null) {
			String producto = request.getParameter("par");
			if (producto != null) {
				borrarEnCarrito(carrito, producto);
			}
		}
//		Retornar	la	vista	con	parámetro	"carrito"
		request.setAttribute("paresCarrito", carrito);
		getServletContext().getRequestDispatcher("/vista-carrito.jsp").forward(request, response);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Tienda	SDI:	carrito</TITLE></HEAD>");
		out.println("<BODY>");
		out.println(carritoEnHTML(carrito) + "<br>");
		out.println("<a	href=\"index.jsp\">Volver</a></BODY></HTML>");

	}

	private void borrarEnCarrito(Map<String, Integer> carrito, String claveProducto) {
		if (carrito.get(claveProducto) != null) {// No existe en el carrito por tanot aadimos el nuevo producto
			int numArticulos = (Integer) carrito.get(claveProducto).intValue();// Yya existe en el carrito porta tno
			if (numArticulos >= 2) { // aladimos otra unidad
				carrito.put(claveProducto, new Integer(numArticulos - 1));
			} else
				carrito.remove(claveProducto);
		}

	}

	private String carritoEnHTML(Map<String, Integer> carrito) {
		String carritoEnHTML = "";

		for (String key : carrito.keySet())
			carritoEnHTML += "<p>[" + key + "], " + carrito.get(key) + " unidades </p>";
		return carritoEnHTML;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
