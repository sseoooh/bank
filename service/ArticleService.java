package service;

import java.util.ArrayList;
import domain.ArticleBean;

public interface ArticleService {
	// CREATE
	public void createAticle(String title, String content, String writer);

	// READ
	public ArrayList<ArticleBean> list();

	public ArrayList<ArticleBean> findWriter(String writer);

	public ArticleBean findTitle(String title);

	public int countSeq();

	public String redDate();

	// UPDATE
	public void updateContent(String title, String content);

	// DELETE
	public void deleteSeq(String seq);
}