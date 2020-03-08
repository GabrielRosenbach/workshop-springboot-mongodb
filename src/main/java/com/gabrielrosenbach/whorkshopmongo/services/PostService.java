package com.gabrielrosenbach.whorkshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrosenbach.whorkshopmongo.domain.Post;
import com.gabrielrosenbach.whorkshopmongo.exception.ObjectNotFoundException;
import com.gabrielrosenbach.whorkshopmongo.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		
		Optional<Post> post = postRepository.findById(id);
		
		if (!post.isPresent()) {
			
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return post.get();
	}
	
	public List<Post> findByTitle(String text) {
		
		return postRepository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		
		return postRepository.fullSearch(text, minDate, maxDate);
	}
	
}
