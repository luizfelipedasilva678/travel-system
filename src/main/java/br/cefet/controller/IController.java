package br.cefet.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface IController {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
