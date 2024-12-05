package org.mea.web.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestInfo {
	
  private String apiId;
  private String ver;
  private Long ts;
  private String action;
  private String did;
  private String key;
  private String msgId;
  private String username;
  private String userId;
}
