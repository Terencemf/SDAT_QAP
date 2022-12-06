package com.keyin.tournaments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@RestController
public class TournamentController {
    @Autowired
    private TournamentRepository repo;


    @GetMapping("/tournaments")
    public List<Tournament> getTournaments() {
        return (List<Tournament>) repo.findAll();
    }

    @PostMapping("/tournaments")
    public void createTournament(@RequestBody Tournament tournament) {
        repo.save(tournament);
    }
    @PutMapping("/tournament/{location}")
    public void updateTournament(@PathVariable String location, @RequestBody Tournament tournament, HttpServletResponse response) {
        Optional<Tournament> returnValue = repo.findById(Long.parseLong(location));
        Tournament tournamentToUpdate;
        if (returnValue.isPresent()) {
            tournamentToUpdate = returnValue.get();
            tournamentToUpdate.setLocation(tournament.getLocation());
            repo.save(tournamentToUpdate);
        } else {
            try {
                response.sendError(404, "Tournament with location: " + tournament.getLocation() + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @DeleteMapping("/tournament/{id}")
    public void deleteTournament(@PathVariable Long id)
    {
        repo.deleteById(id);
    }
}
