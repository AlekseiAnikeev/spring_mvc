package ru.agentche.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 07.12.2022
 */
@Getter
@Setter
public class Post {
    private long id;
    private String content;
    private boolean isRemoved;

    public Post() {
    }

    public Post(long id, String content) {
        this.id = id;
        this.content = content;
        isRemoved = false;
    }

    public Post createNew(Long id) {
        return new Post(id, content);
    }
}
