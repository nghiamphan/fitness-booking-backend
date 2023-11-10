package smu.mcda5540.fitnessbooking.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ErrorInfo {
    private int errorCode;
    private String errorMessage;
    private LocalDateTime timestamp;
}