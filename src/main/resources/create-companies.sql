begin;

CREATE TABLE public.companies
(
    companyname varchar(150) NOT NULL,
    tin varchar(10) NOT NULL,
    phonenumber varchar(50),
);
CREATE UNIQUE INDEX companies_tin_uindex ON public.companies (tin);

commit;