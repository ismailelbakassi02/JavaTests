package com.project.atelier_2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.*;

public class HelloServletTest {

    @Test
    public void testHelloServlet() throws Exception {
        // Mocks
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Préparation du PrintWriter pour capturer la sortie
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

        // Création et exécution du servlet
        HelloServlet servlet = new HelloServlet();
        servlet.init(); // Sinon le message sera null
        servlet.doGet(request, response);

        writer.flush(); // s'assurer que tout est écrit

        // Vérifier le contenu généré
        String result = stringWriter.toString();
        assert(result.contains("Hello World!"));
    }
}
