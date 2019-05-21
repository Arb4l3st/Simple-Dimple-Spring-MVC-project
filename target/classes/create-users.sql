begin;

CREATE TABLE public.users
(
    fio varchar(200),
    dater varchar(10),
    email varchar(50),
    companyname varchar(150),
    id int PRIMARY KEY NOT NULL,
);
CREATE UNIQUE INDEX users_id_uindex ON public.users (id);

commit;