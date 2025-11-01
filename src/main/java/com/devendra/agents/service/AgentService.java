package com.devendra.agents.service;
import com.devendra.agents.dto.AgentDto;
import lombok.Getter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class AgentService {
    List<AgentDto> agents;
    public AgentService(){
        AgentDto agentDto = new AgentDto();
        agentDto.setId("1");
        agentDto.setName("Gemini");
       this.agents = new ArrayList<>(List.of(agentDto));
    }
}
