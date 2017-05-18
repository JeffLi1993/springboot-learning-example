package cn.ictgu.chat.Model;

import lombok.Data;

/**
 * Created by Silence on 2017/4/25.
 */
@Data
public class ChatMessage {

  private String username;

  private String nickname;

  private String avatar;

  private String content;

  private String sendTime;

}
