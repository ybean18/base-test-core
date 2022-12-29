package exam.test.core.assembly.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NzmimeepazxkubdpnDto {

	@JsonProperty("BILL_ID")       private String bill_id;       // 의안ID
	@JsonProperty("BILL_NO")       private String bill_no;       // 의안번호
	@JsonProperty("BILL_NAME")     private String bill_name;     // 법률안명
	@JsonProperty("COMMITTEE")     private String committee;     // 소관위원회
	@JsonProperty("PROPOSE_DT")    private String propose_dt;    // 제안일
	@JsonProperty("PROC_RESULT")   private String proc_result;   // 처리상태
	@JsonProperty("AGE")           private String age;           // 대수
	@JsonProperty("DETAIL_LINK")   private String detail_link;   // 상세페이지
	@JsonProperty("PROPOSER")      private String proposer;      // 제안자
	@JsonProperty("MEMBER_LIST")   private String member_list;   // 제안자목록링크
	@JsonProperty("RST_PROPOSER")  private String rst_proposer;  // 대표발의자
	@JsonProperty("PUBL_PROPOSER") private String publ_proposer; // 공동발의자
	@JsonProperty("COMMITTEE_ID")  private String committee_id;  // 소관위원회ID
	
	
}