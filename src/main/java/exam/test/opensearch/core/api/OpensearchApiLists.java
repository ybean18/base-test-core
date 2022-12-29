package exam.test.opensearch.core.api;

public enum OpensearchApiLists {

	SEARCH_ALL               ("/search/all",               "의안, 뉴스, 인물 통합검색"),
	SEARCH_BILL              ("/search/bill",              "의안 상세검색"),
	SEARCH_NEWS              ("/search/news",              "뉴스 상세검색"),
	SEARCH_MNA               ("/search/mna",               "인물 상세검색"),
	SEARCH_RELATED_NEWS      ("/search/related_news",      "인물관련 뉴스검색"),
	SEARCH_BILL_RELATED_NEWS ("/search/bill_related_news", "의안관련 뉴스검색"),
	SEARCH_RELATED_SOCIAL    ("/search/related_social",    "관련 소셜데이터 검색"),
	SEARCH_ALL_MNA_NEWS      ("/search/all_mna_news",      "오늘의인물"),
	SEARCH_LAW               ("/search/law",               "법령 검색"),
	SEARCH_RPT_POLICY        ("/search/rpt_policy",        "정책 검색"),
	SEARCH_POL               ("/search/pol",               "입법예고"),
	SEARCH_PRC               ("/search/prc",               "회의록");

	private final String apiUri;
	private final String apiName;

	OpensearchApiLists(String apiUri, String apiName) {
		this.apiUri  = apiUri;
		this.apiName = apiName;
	}

	public String apiUri() {
		return this.apiUri;
	}

	public String apiName() {
		return this.apiName;
	}
}