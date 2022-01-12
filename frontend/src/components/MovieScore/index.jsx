import MovieStars from "components/MovieStars";

import './styles.css';

function MovieScore() {

    const score = 3.5;
    const count = 13;
    
    return (
        <div className="dsmovie-score-container">
            <div className="dsmovie-score-value">{score > 0 ? score.toFixed(1) : '-'}</div>
            <MovieStars />
            <p className="dsmovie-score-count">{count} avaliações</p>
        </div>
    );
}

export default MovieScore;