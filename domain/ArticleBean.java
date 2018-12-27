package domain;

public class ArticleBean {
	private int seq; // 글번호
	private String title, content, writer, redDate; // content 게시글 redDate 글쓴시각

	public int getSeq() {
		return seq; // 1000부터 1씩 증가
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRedDate() {
		return redDate;
	}

	public void setRedDate(String redDate) {
		this.redDate = redDate;
	}

	@Override
	public String toString() {
		return "ArticleBean [seq=" + seq + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", redDate=" + redDate + "]";
	}

}
