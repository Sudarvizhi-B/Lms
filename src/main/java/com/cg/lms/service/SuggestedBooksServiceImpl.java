package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.lms.entity.SuggestedBooks;
import com.cg.lms.repository.ISuggestedBooksRepository;

@Service
public class SuggestedBooksServiceImpl implements ISuggestedBooksService {

	@Autowired
	ISuggestedBooksRepository sbrepo;
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(SuggestedBooksServiceImpl.class);

	// Suggest Books
	@Override
	public SuggestedBooks suggestBooks(SuggestedBooks book) {
		logger.info("Adding Suggested Books Details");
		return sbrepo.save(book);
	}

	// Update Suggested Books
	@Override
	public SuggestedBooks updateSuggestedBookStatus(SuggestedBooks book) {
		// Getting Books By Id
		Optional<SuggestedBooks> sb2 = sbrepo.findById(book.getId());
		if (!sb2.isPresent()) {
			return null;
		}
		sb2.get().setTitle(book.getTitle());
		sb2.get().setSubject(book.getSubject());
		sb2.get().setAuthor(book.getAuthor());
		sb2.get().setPublications(book.getPublications());
		sb2.get().setDescription(book.getDescription());
		sb2.get().setSuggested_date(book.getSuggested_date());
		sb2.get().setStatus(book.getStatus());
		logger.info("Updating Suggested Books Details");
		return sbrepo.save(sb2.get());
	}

	// Delete Suggested Books
	@Override
	public SuggestedBooks deleteSuggestedBooks(int id) {
		// getting books by id
		Optional<SuggestedBooks> sb = sbrepo.findById(id);
		if (!sb.isPresent()) {
			return null;
		}
		logger.info("Deleting Suggested Books");
		sbrepo.deleteById(id);
		return sb.get();
	}

	// View SuggestedBooks By Id
	@Override
	public SuggestedBooks viewSuggestedBookDetails(int id) {
		// getting books by id
		Optional<SuggestedBooks> sb1 = sbrepo.findById(id);
		if (!sb1.isPresent()) {
			return null;
		}
		logger.info("Viewing Suggested Books Details");
		return sb1.get();
	}

	// View Suggested Books List
	@Override
	public List<SuggestedBooks> viewSuggestedBooksList() {
		return sbrepo.findAll();
	}

}
