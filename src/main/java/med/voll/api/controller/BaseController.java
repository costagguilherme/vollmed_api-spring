package med.voll.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    public ResponseEntity<?> errorResponse(HttpStatus statusCode, String customMessage) {
        Object errorResponse = new Object() {
            public final boolean success = false;
            public final int code = statusCode.value();
            public final String message = customMessage;
        };
        return ResponseEntity.status(statusCode).body(errorResponse);
    }
}
