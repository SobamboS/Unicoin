package africa.semicolon.unicoin.Utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;
@Data
@AllArgsConstructor
@Builder
public class ApiResponse{
    private ZonedDateTime timeStamp;
    private boolean isSuccessful;
    private Object data;
    private int status;
    private String path;
}
