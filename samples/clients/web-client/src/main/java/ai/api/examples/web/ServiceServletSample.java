/**
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package ai.api.examples.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ai.api.AIServiceException;
import ai.api.model.AIResponse;
import ai.api.web.AIServiceServlet;


/**
 * Servlet implementation class AIServiceServlet
 */
@WebServlet(urlPatterns = {"/ai"}, initParams = {
	@WebInitParam(name = ServiceServletSample.PARAM_API_AI_KEY, value = "e2e78a73b0b1406d92ab47c152a9aab2"),
	@WebInitParam(name = ServiceServletSample.PROXY_HOST, value = "proxy.us.dhl.com"),
	@WebInitParam(name = ServiceServletSample.PROXY_PORT, value = "8080")
})
public class ServiceServletSample extends AIServiceServlet {
  private static final long serialVersionUID = 1L;
  
  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      AIResponse aiResponse = request(request.getParameter("query"), request.getSession());
      response.setContentType("text/plain");
      response.getWriter().append(aiResponse.getResult().getFulfillment().getSpeech());
    } catch (AIServiceException e) {
      e.printStackTrace();
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
