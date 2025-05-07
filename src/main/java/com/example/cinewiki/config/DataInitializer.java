package com.example.cinewiki.config;

import com.example.cinewiki.model.Director;
import com.example.cinewiki.model.Movie;
import com.example.cinewiki.repository.DirectorRepository;
import com.example.cinewiki.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public DataInitializer(DirectorRepository directorRepository, MovieRepository movieRepository) {
        this.directorRepository = directorRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if we already have data
        if (directorRepository.count() > 0) {
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Create directors
        Director rajamouli = new Director("S.S. Rajamouli", sdf.parse("1973-10-10"), "Indian",
                "Koduri Srisaila Sri Rajamouli is an Indian film director and screenwriter who primarily works in Telugu cinema.");
        directorRepository.save(rajamouli);

        Director sukumar = new Director("Sukumar", sdf.parse("1970-01-11"), "Indian",
                "Sukumar is an Indian film director, screenwriter and producer known for his works in Telugu cinema.");
        directorRepository.save(sukumar);

        Director trivikram = new Director("Trivikram Srinivas", sdf.parse("1971-11-07"), "Indian",
                "Trivikram Srinivas is an Indian film director and screenwriter known for his works in Telugu cinema.");
        directorRepository.save(trivikram);

        Director koratala = new Director("Koratala Siva", sdf.parse("1975-06-15"), "Indian",
                "Koratala Siva is an Indian film director, screenwriter and dialogue writer known for his works in Telugu cinema.");
        directorRepository.save(koratala);

        Director prashanth = new Director("Prashanth Neel", sdf.parse("1980-06-04"), "Indian",
                "Prashanth Neel is an Indian film director and screenwriter who works in Kannada and Telugu cinema.");
        directorRepository.save(prashanth);

        Director sujeeth = new Director("Sujeeth", sdf.parse("1991-01-15"), "Indian",
                "Sujeeth is an Indian film director and screenwriter who works in Telugu cinema.");
        directorRepository.save(sujeeth);

        Director nag = new Director("Nag Ashwin", sdf.parse("1989-04-23"), "Indian",
                "Nag Ashwin is an Indian film director and screenwriter who works in Telugu cinema.");
        directorRepository.save(nag);

        Director anil = new Director("Anil Ravipudi", sdf.parse("1982-11-23"), "Indian",
                "Anil Ravipudi is an Indian film director and screenwriter known for his works in Telugu cinema.");
        directorRepository.save(anil);

        Director dasaradh = new Director("Dasaradh", sdf.parse("1970-05-12"), "Indian",
                "Dasaradh is an Indian film director known for his works in Telugu cinema.");
        directorRepository.save(dasaradh);

        Director karunakaran = new Director("Karunakaran", sdf.parse("1972-08-19"), "Indian",
                "Karunakaran is an Indian film director known for his works in Telugu cinema.");
        directorRepository.save(karunakaran);

        // Create movies
        Movie baahubali = new Movie("Baahubali: The Beginning", 2015, "Action, Drama",
                "In ancient India, an adventurous and daring man becomes involved in a decades-old feud between warring cousins.",
                180.0, 650.0);
        baahubali.setDirector(rajamouli);
        movieRepository.save(baahubali);

        Movie baahubali2 = new Movie("Baahubali 2: The Conclusion", 2017, "Action, Drama",
                "When Shiva, the son of Bahubali, learns about his heritage, he begins to look for answers. His story is juxtaposed with past events that unfolded in the Mahishmati Kingdom.",
                250.0, 1810.0);
        baahubali2.setDirector(rajamouli);
        movieRepository.save(baahubali2);

        Movie rangasthalam = new Movie("Rangasthalam", 2018, "Action, Drama",
                "Chitti Babu is a partially deaf, happy-go-lucky man who doesn't let his disability deter him. His brother Kumar Babu returns from Dubai only to see that nothing in the village has changed.",
                60.0, 216.0);
        rangasthalam.setDirector(sukumar);
        movieRepository.save(rangasthalam);

        Movie pushpa = new Movie("Pushpa: The Rise", 2021, "Action, Crime, Drama",
                "A laborer rises through the ranks of a red sandalwood smuggling syndicate, making some powerful enemies in the process.",
                100.0, 365.0);
        pushpa.setDirector(sukumar);
        movieRepository.save(pushpa);

        Movie mirchi = new Movie("Mirchi", 2013, "Action, Drama, Romance",
                "A man returns to India to make peace between two families but must hide his true identity.",
                35.0, 80.0);
        mirchi.setDirector(koratala);
        movieRepository.save(mirchi);

        Movie bharathAneNenu = new Movie("Bharath Ane Nenu", 2018, "Action, Drama",
                "A young Oxford University graduate returns to India and becomes the Chief Minister of Andhra Pradesh, working to fight against corruption.",
                100.0, 230.0);
        bharathAneNenu.setDirector(koratala);
        movieRepository.save(bharathAneNenu);

        Movie salaar = new Movie("Salaar: Part 1 - Ceasefire", 2023, "Action, Thriller",
                "A gang leader tries to keep a promise made to his dying friend and finds himself in a new city and a larger criminal conspiracy.",
                270.0, 615.0);
        salaar.setDirector(prashanth);
        movieRepository.save(salaar);

        Movie saaho = new Movie("Saaho", 2019, "Action, Thriller",
                "A battle for power and wealth among crime lords leaves countless innocent lives at stake, and an undercover cop must intervene.",
                350.0, 433.0);
        saaho.setDirector(sujeeth);
        movieRepository.save(saaho);

        Movie kalki = new Movie("Kalki 2898 AD", 2024, "Action, Sci-Fi",
                "Set in a futuristic world, the film follows a warrior who embarks on a journey to fulfill an ancient prophecy.",
                600.0, 1000.0);
        kalki.setDirector(nag);
        movieRepository.save(kalki);

        Movie sarileruNeekevvaru = new Movie("Sarileru Neekevvaru", 2020, "Action, Comedy",
                "An army major is sent to Kurnool to give company to his injured colleague's family and ends up locking horns with a corrupt minister.",
                75.0, 260.0);
        sarileruNeekevvaru.setDirector(anil);
        movieRepository.save(sarileruNeekevvaru);

        Movie mrPerfect = new Movie("Mr. Perfect", 2011, "Comedy, Drama, Romance",
                "A man who believes in winning at all costs eventually learns the value of relationships.",
                25.0, 45.0);
        mrPerfect.setDirector(dasaradh);
        movieRepository.save(mrPerfect);

        Movie darling = new Movie("Darling", 2010, "Comedy, Drama, Romance",
                "A man falls in love with a girl who is getting married to someone else, and complications arise.",
                20.0, 40.0);
        darling.setDirector(karunakaran);
        movieRepository.save(darling);
    }
}