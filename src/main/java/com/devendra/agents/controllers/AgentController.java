package com.devendra.agents.controllers;

import com.devendra.agents.dto.AgentDto;
import com.devendra.agents.service.AgentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/agents")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping
    public ResponseEntity<List<AgentDto>> getAgents() {
        return ResponseEntity.ok(agentService.getAgents());
    }
}
