package com.enviro.assessment.grad001.neo.magolela.exception;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record ErrorResponse(String path,
                            String message,
                            int StatusCode,
                            LocalDateTime localDateTime) {
}
