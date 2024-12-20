package Election;

import java.util.HashSet;
import java.util.Set;

public class Voter {

    private String voteId;
    private boolean status;
    private String password;
    private String name;
    private Set<String> voted;






    public Voter(String voteId,String name, String password) {
        this.voteId = voteId;
        this.status = false;
        this.name = name;
        this.password = password;
        voted =  new HashSet<>();
    }
    public String getVoterId(){
        return this.voteId;
    }


    public boolean  authenticatelogin(String passCode,String voterId){
         if (!this.password.equals(passCode)){
            throw new IllegalArgumentException("Invalid password entered.");
        }
        if (!this.voteId.equals(voterId)) {
            throw new IllegalArgumentException("Invalid voteID entered.");
        }
        else {
            return true;
        }
    }

    public void castVote (String voterId,String passCode,String candidateId ){
        Registration registration = new Registration();
        authenticatelogin(passCode,voterId);
        Candidate candidate = registration.findCandidate(candidateId);
        candidate.addVote();
    }

    public Set<String> getVoted() {
        return voted;
    }
}
