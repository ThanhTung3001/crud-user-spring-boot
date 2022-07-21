package edu.uploadfile.profile_upload.Model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {

    private String message;
    private Object data;
    private List<Object> options;
    private int code;
}
