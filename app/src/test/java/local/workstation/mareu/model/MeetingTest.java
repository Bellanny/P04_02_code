package local.workstation.mareu.model;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static local.workstation.mareu.utils.Util.fromTime;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class MeetingTest {
    private final String invalid_email = "test";

    @Test
    void givenValidEmailAddresses_whenInstatiateMeeting_thenGetValidParticipants() {
        List<String> participants  = Arrays.asList(
                "audreyluce54@gmail.com",
                "audrey_luce@hotmail.fr");

        Meeting meeting = new Meeting("Salle 1",
                fromTime("11:00"),
                fromTime("11:30"),
                "Just a meeting",
                participants);

        assertThat(participants, CoreMatchers.is(meeting.getParticipants()));
    }

    @Test
    void givenInvalidEmailAddresses_whenInstatiateMeeting_thenGetValidParticipants() {
        List<String> participants  = new LinkedList<>(Arrays.asList(
                "audreyluce54@gmail.com",
                "audrey_luce@hotmail.fr",
                invalid_email));

        Meeting meeting = new Meeting("Salle 1",
                fromTime("11:00"),
                fromTime("12:00"),
                "Just a meeting",
                participants);

        // Remove invalid email address
        participants.remove(invalid_email);

        // Compare
        assertThat(participants, CoreMatchers.is(meeting.getParticipants()));
    }
}