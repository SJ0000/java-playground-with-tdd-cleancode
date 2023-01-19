package blackjack.dto;

import blackjack.domain.Cards;
import blackjack.domain.Participant;
import blackjack.domain.state.State;

public class ParticipantDto {

    private final String name;
    private final State state;

    public ParticipantDto(Participant participant) {
        this.name = participant.getName();
        this.state = participant.getState();
    }

    public String getName() {
        return name;
    }

    public int getPoint(){
        return state.cards().calculatePoint();
    }

    public String getInfo(){
        return name + ": " + state.cards();
    }
}
