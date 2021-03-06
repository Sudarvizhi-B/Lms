package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.SuggestedBooks;

public interface ISuggestedBooksService {

	public SuggestedBooks suggestBooks(SuggestedBooks book);

	public SuggestedBooks updateSuggestedBookStatus(int id,SuggestedBooks book);

	public SuggestedBooks deleteSuggestedBooks(int id);

	public SuggestedBooks viewSuggestedBookDetails(int id);

	public List<SuggestedBooks> viewSuggestedBooksList();
	
	public List<SuggestedBooks> findAllByTitle(String title);

}