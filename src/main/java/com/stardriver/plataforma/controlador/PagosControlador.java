package com.stardriver.plataforma.controlador;

import com.stardriver.plataforma.entidad.Pago;
import com.stardriver.plataforma.repositorio.PagoRepositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

@Controller
public class PagosControlador {
    @Autowired
    private PagoRepositorio pagos;

    @PostMapping("/estudiante/realizar-pago")
    private String pagos(@RequestParam Map<String, String> params, HttpSession session, Model model) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }

        String accion = params.get("accion");

        if ("pagar".equals(accion)) {

            int id = Integer.parseInt(params.get("id_pago"));

            Optional<Pago> pago = pagos.findById(id);

            pago.ifPresent(value -> {
                String metodo = params.get("metodo");

                value.setMetodo(metodo);
                value.setEstado("Pagado");
                value.setFecha(LocalDate.now());

                pagos.save(value);
            });
            model.addAttribute("exito", pago.isPresent());
        }
        return "estudiante/pagos.html";
    }
}
