DROP TABLE IF EXISTS `lucky_draw_reward`;
CREATE TABLE `lucky_draw_reward`
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    generated_number VARCHAR(25) not null comment '생성된 번호',
    generated_date   DATETIME    not null comment '생성된 날짜',
    user_id          BIGINT      not null comment '유저 아이디',
    expired          TINYINT     not null comment '만료 여부',
    created          datetime,
    updated          datetime,
    key idxGeneratedDate (generated_date)
);