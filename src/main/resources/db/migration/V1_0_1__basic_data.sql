INSERT INTO task (id, name, rejected)
VALUES ('bd60984e-047b-11ed-b939-0242ac120002', 'first task', false);

INSERT INTO subtask (id, deadline, done, description, rejected, remember_time, task_id, title)
VALUES ('6a9e3eb4-047a-11ed-b939-0242ac120002',
        '2022-12-12 00:00:00',
        false,
        'first desc',
        false,
        2,
        'bd60984e-047b-11ed-b939-0242ac120002',
        'first subtask');