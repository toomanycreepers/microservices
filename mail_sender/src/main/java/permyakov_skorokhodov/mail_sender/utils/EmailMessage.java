package permyakov_skorokhodov.mail_sender.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailMessage {
    private String taskId;
    private String from;
    private String to;
    private String subject;
    private String text;
}
