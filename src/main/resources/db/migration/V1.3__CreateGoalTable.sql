DROP TABLE IF EXISTS `goal`;
CREATE TABLE goal
(
    id                   BIGINT       NOT NULL comment 'id',
    reader_user_id       BIGINT       NOT NULL comment '목표 생성자 id',
    maximum_participants INT          NOT NULL comment '참여가능 최대 인원',
    minimum_participants INT          NOT NULL comment '참여가능 최소 인원',
    goal_name            VARCHAR(255) NOT NULL comment '목표 명',
    start_date           datetime     NOT NULL comment '시작 일',
    end_date             datetime     NOT NULL comment '종료 일',
    created              datetime     NULL,
    updated              datetime     NULL,
    CONSTRAINT pk_goal PRIMARY KEY (id)
);

DROP TABLE IF EXISTS `goal_participants`;
CREATE TABLE goal_participants
(
    id                  BIGINT              NOT NULL,
    goal_id             BIGINT              NOT NULL,
    participant_user_id BIGINT              NOT NULL,
    status              VARCHAR(10)         NOT NULL,
    penalty_count       TINYINT DEFAULT 0   NOT NULL,
    achievement_rate    DOUBLE  DEFAULT 0.0 NOT NULL,
    created             datetime            NULL,
    updated             datetime            NULL,
    CONSTRAINT pk_goal_participants PRIMARY KEY (id)
);