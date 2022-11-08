package com.kelvinykk511.chatty.model;

import com.kelvinykk511.chatty.enums.StatusEnum;
import lombok.Data;

/**
 * @author Kelvin Yang
 * @datetime 7/11/2022 5:18 pm
 */

@Data
public class Message {

    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private StatusEnum status;

}
