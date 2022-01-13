package com.devsup.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsup.dsmovie.dto.MovieDTO;
import com.devsup.dsmovie.entities.Movie;
import com.devsup.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true )
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = movieRepository.findAll(pageable);
		
		Page<MovieDTO> movies = result.map(x -> new MovieDTO(x));
		return movies;
	}
	
	@Transactional(readOnly = true )
	public MovieDTO findById(Long id) {
		Movie result = movieRepository.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		return dto;
	}
}
