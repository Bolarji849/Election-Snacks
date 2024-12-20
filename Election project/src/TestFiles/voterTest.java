package TestFiles;

import Election.Candidate;
import Election.Registration;
import Election.Voter;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class voterTest {
    @Test

    public void test_that_voter_can_login_using_the_correct_details(){
        Voter voter = new Voter("v12gh","john","1234");
     boolean isAuthenticate =  voter.authenticatelogin("1234","v12gh");
        assertTrue(voter.authenticatelogin("1234","v12gh"), "User should be able to login ");

    }

    @Test
    public void test_that_when_voter_login_using_the_wrong_password_it_throw_an_error(){
        Voter voter = new Voter("v19fkr","Hakim","7263");
        assertThrows(IllegalArgumentException.class, () -> voter.authenticatelogin("v12fh","Hakim"));
    }

    @Test
    public void test_that_voter_can_cast_vote(){
        Registration registration = new Registration();
        Voter voter = new Voter("v11rkl","Godon","3489");
        Candidate candidate =  registration.registerCandidate("bolaji", "president");
        System.out.println(candidate.getCandidateId());
        voter.castVote("v11rkl","3489", candidate.getCandidateId());
        assertEquals(1,candidate.getVoteCounter());

    }
   @Test
    public void test_that_voter_can_be_registered(){
        Registration registration = new Registration();
        Voter voter =  registration.registerVoter("sameul","1129");
        assertFalse(registration.getVoters().isEmpty());


    }
    @Test
    public void test_that_more_than_one_voter_can_be_registered(){
        Registration registration = new Registration();
        Voter voter =  registration.registerVoter("sameul","1129");
        registration.registerVoter("ganmed","1159");
        registration.registerVoter("ganmed","1115");
        assertEquals(3,registration.getVoters().size());

    }
   @Test
    public void test_that_Candidate_can_be_registered(){
        Registration registration = new Registration();
        Candidate candidate =  registration.registerCandidate("Adewale","president");
       assertFalse(registration.getVoters().isEmpty());
}
}