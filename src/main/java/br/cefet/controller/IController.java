package br.cefet.controller;
import javax.servlet.http.*;


public interface IController {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
