--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5
-- Dumped by pg_dump version 17.5

-- Started on 2026-01-12 10:20:31

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 229 (class 1255 OID 24652)
-- Name: fn_total_matriculas_aluno(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.fn_total_matriculas_aluno(p_id_aluno integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
    total INT;
BEGIN
    SELECT COUNT(*) INTO total
    FROM Matricula
    WHERE id_aluno = p_id_aluno;

    RETURN total;
END;
$$;


ALTER FUNCTION public.fn_total_matriculas_aluno(p_id_aluno integer) OWNER TO postgres;

--
-- TOC entry 230 (class 1255 OID 24653)
-- Name: sp_matricular_aluno(integer, integer, integer, date); Type: PROCEDURE; Schema: public; Owner: postgres
--

CREATE PROCEDURE public.sp_matricular_aluno(IN p_id_aluno integer, IN p_id_disciplina integer, IN p_id_turma integer, IN p_data date)
    LANGUAGE plpgsql
    AS $$
BEGIN
    INSERT INTO Matricula (id_aluno, id_disciplina, id_turma, data_matricula)
    VALUES (p_id_aluno, p_id_disciplina, p_id_turma, p_data);
END;
$$;


ALTER PROCEDURE public.sp_matricular_aluno(IN p_id_aluno integer, IN p_id_disciplina integer, IN p_id_turma integer, IN p_data date) OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 24579)
-- Name: aluno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.aluno (
    id_aluno integer NOT NULL,
    nome character varying(100) NOT NULL,
    email character varying(100),
    data_nascimento date
);


ALTER TABLE public.aluno OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 24578)
-- Name: aluno_id_aluno_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.aluno_id_aluno_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.aluno_id_aluno_seq OWNER TO postgres;

--
-- TOC entry 4957 (class 0 OID 0)
-- Dependencies: 217
-- Name: aluno_id_aluno_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.aluno_id_aluno_seq OWNED BY public.aluno.id_aluno;


--
-- TOC entry 224 (class 1259 OID 24600)
-- Name: disciplina; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.disciplina (
    id_disciplina integer NOT NULL,
    nome character varying(100) NOT NULL,
    carga_horaria integer,
    id_turma integer
);


ALTER TABLE public.disciplina OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 24599)
-- Name: disciplina_id_disciplina_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.disciplina_id_disciplina_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.disciplina_id_disciplina_seq OWNER TO postgres;

--
-- TOC entry 4958 (class 0 OID 0)
-- Dependencies: 223
-- Name: disciplina_id_disciplina_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.disciplina_id_disciplina_seq OWNED BY public.disciplina.id_disciplina;


--
-- TOC entry 225 (class 1259 OID 24611)
-- Name: leciona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leciona (
    id_professor integer NOT NULL,
    id_disciplina integer NOT NULL
);


ALTER TABLE public.leciona OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 24627)
-- Name: matricula; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.matricula (
    id_matricula integer NOT NULL,
    id_aluno integer NOT NULL,
    id_disciplina integer NOT NULL,
    id_turma integer NOT NULL,
    data_matricula date
);


ALTER TABLE public.matricula OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 24626)
-- Name: matricula_id_matricula_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.matricula_id_matricula_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.matricula_id_matricula_seq OWNER TO postgres;

--
-- TOC entry 4959 (class 0 OID 0)
-- Dependencies: 226
-- Name: matricula_id_matricula_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.matricula_id_matricula_seq OWNED BY public.matricula.id_matricula;


--
-- TOC entry 220 (class 1259 OID 24586)
-- Name: professor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.professor (
    id_professor integer NOT NULL,
    nome character varying(100) NOT NULL,
    especialidade character varying(100)
);


ALTER TABLE public.professor OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 24585)
-- Name: professor_id_professor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.professor_id_professor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.professor_id_professor_seq OWNER TO postgres;

--
-- TOC entry 4960 (class 0 OID 0)
-- Dependencies: 219
-- Name: professor_id_professor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.professor_id_professor_seq OWNED BY public.professor.id_professor;


--
-- TOC entry 222 (class 1259 OID 24593)
-- Name: turma; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.turma (
    id_turma integer NOT NULL,
    nome character varying(50) NOT NULL,
    ano integer
);


ALTER TABLE public.turma OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 24592)
-- Name: turma_id_turma_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.turma_id_turma_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.turma_id_turma_seq OWNER TO postgres;

--
-- TOC entry 4961 (class 0 OID 0)
-- Dependencies: 221
-- Name: turma_id_turma_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.turma_id_turma_seq OWNED BY public.turma.id_turma;


--
-- TOC entry 228 (class 1259 OID 24648)
-- Name: vw_aluno_disciplinas; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.vw_aluno_disciplinas AS
 SELECT a.nome AS nome_aluno,
    d.nome AS nome_disciplina,
    m.data_matricula
   FROM ((public.matricula m
     JOIN public.aluno a ON ((m.id_aluno = a.id_aluno)))
     JOIN public.disciplina d ON ((m.id_disciplina = d.id_disciplina)));


ALTER VIEW public.vw_aluno_disciplinas OWNER TO postgres;

--
-- TOC entry 4772 (class 2604 OID 24582)
-- Name: aluno id_aluno; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno ALTER COLUMN id_aluno SET DEFAULT nextval('public.aluno_id_aluno_seq'::regclass);


--
-- TOC entry 4775 (class 2604 OID 24603)
-- Name: disciplina id_disciplina; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.disciplina ALTER COLUMN id_disciplina SET DEFAULT nextval('public.disciplina_id_disciplina_seq'::regclass);


--
-- TOC entry 4776 (class 2604 OID 24630)
-- Name: matricula id_matricula; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matricula ALTER COLUMN id_matricula SET DEFAULT nextval('public.matricula_id_matricula_seq'::regclass);


--
-- TOC entry 4773 (class 2604 OID 24589)
-- Name: professor id_professor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.professor ALTER COLUMN id_professor SET DEFAULT nextval('public.professor_id_professor_seq'::regclass);


--
-- TOC entry 4774 (class 2604 OID 24596)
-- Name: turma id_turma; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turma ALTER COLUMN id_turma SET DEFAULT nextval('public.turma_id_turma_seq'::regclass);


--
-- TOC entry 4942 (class 0 OID 24579)
-- Dependencies: 218
-- Data for Name: aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.aluno (id_aluno, nome, email, data_nascimento) FROM stdin;
2	João Silva	joao.silva@email.com	2005-04-10
3	Maria Oliveira	maria.oliveira@email.com	2004-12-05
4	Carlos Souza	carlos.souza@email.com	2005-01-22
5	Ana Lima	ana.lima@email.com	2005-03-17
6	felipe	felipe@gmail.com	2005-11-16
7	Eduarda Moura	eduardamoura@gmail.com	2005-04-23
8	Luiz	luiz@gmail.com	2005-02-20
\.


--
-- TOC entry 4948 (class 0 OID 24600)
-- Dependencies: 224
-- Data for Name: disciplina; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.disciplina (id_disciplina, nome, carga_horaria, id_turma) FROM stdin;
2	Matemática	60	1
3	História	40	1
4	Português	60	2
5	Geografia	50	2
6	Filosofia	40	2
7	Matemática	60	2
8	História	40	2
9	Português	60	1
10	Geografia	50	1
11	Filosofia	40	1
\.


--
-- TOC entry 4949 (class 0 OID 24611)
-- Dependencies: 225
-- Data for Name: leciona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leciona (id_professor, id_disciplina) FROM stdin;
2	2
3	3
\.


--
-- TOC entry 4951 (class 0 OID 24627)
-- Dependencies: 227
-- Data for Name: matricula; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.matricula (id_matricula, id_aluno, id_disciplina, id_turma, data_matricula) FROM stdin;
4	2	2	1	2025-02-02
5	3	3	2	2025-02-05
6	4	4	2	2025-02-06
8	5	3	1	2025-02-12
10	8	2	1	2025-06-17
11	4	11	1	2025-06-12
12	6	5	1	2025-02-01
14	7	4	1	2025-02-25
15	4	7	1	2025-02-23
\.


--
-- TOC entry 4944 (class 0 OID 24586)
-- Dependencies: 220
-- Data for Name: professor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.professor (id_professor, nome, especialidade) FROM stdin;
2	Fernanda Rocha	Matemática
3	Luiz Martins	História
4	Paulo Meireles	Português
1	Ana Martins	Filosofia
5	Mariano	Geografia
\.


--
-- TOC entry 4946 (class 0 OID 24593)
-- Dependencies: 222
-- Data for Name: turma; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.turma (id_turma, nome, ano) FROM stdin;
1	3ºB	2025
2	3ºA	2025
\.


--
-- TOC entry 4962 (class 0 OID 0)
-- Dependencies: 217
-- Name: aluno_id_aluno_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.aluno_id_aluno_seq', 9, true);


--
-- TOC entry 4963 (class 0 OID 0)
-- Dependencies: 223
-- Name: disciplina_id_disciplina_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.disciplina_id_disciplina_seq', 11, true);


--
-- TOC entry 4964 (class 0 OID 0)
-- Dependencies: 226
-- Name: matricula_id_matricula_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.matricula_id_matricula_seq', 15, true);


--
-- TOC entry 4965 (class 0 OID 0)
-- Dependencies: 219
-- Name: professor_id_professor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.professor_id_professor_seq', 5, true);


--
-- TOC entry 4966 (class 0 OID 0)
-- Dependencies: 221
-- Name: turma_id_turma_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.turma_id_turma_seq', 4, true);


--
-- TOC entry 4778 (class 2606 OID 24584)
-- Name: aluno aluno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_pkey PRIMARY KEY (id_aluno);


--
-- TOC entry 4784 (class 2606 OID 24605)
-- Name: disciplina disciplina_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.disciplina
    ADD CONSTRAINT disciplina_pkey PRIMARY KEY (id_disciplina);


--
-- TOC entry 4786 (class 2606 OID 24615)
-- Name: leciona leciona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leciona
    ADD CONSTRAINT leciona_pkey PRIMARY KEY (id_professor, id_disciplina);


--
-- TOC entry 4788 (class 2606 OID 24632)
-- Name: matricula matricula_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matricula
    ADD CONSTRAINT matricula_pkey PRIMARY KEY (id_matricula);


--
-- TOC entry 4780 (class 2606 OID 24591)
-- Name: professor professor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.professor
    ADD CONSTRAINT professor_pkey PRIMARY KEY (id_professor);


--
-- TOC entry 4782 (class 2606 OID 24598)
-- Name: turma turma_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turma
    ADD CONSTRAINT turma_pkey PRIMARY KEY (id_turma);


--
-- TOC entry 4789 (class 2606 OID 24606)
-- Name: disciplina disciplina_id_turma_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.disciplina
    ADD CONSTRAINT disciplina_id_turma_fkey FOREIGN KEY (id_turma) REFERENCES public.turma(id_turma);


--
-- TOC entry 4790 (class 2606 OID 24621)
-- Name: leciona leciona_id_disciplina_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leciona
    ADD CONSTRAINT leciona_id_disciplina_fkey FOREIGN KEY (id_disciplina) REFERENCES public.disciplina(id_disciplina);


--
-- TOC entry 4791 (class 2606 OID 24616)
-- Name: leciona leciona_id_professor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leciona
    ADD CONSTRAINT leciona_id_professor_fkey FOREIGN KEY (id_professor) REFERENCES public.professor(id_professor);


--
-- TOC entry 4792 (class 2606 OID 24633)
-- Name: matricula matricula_id_aluno_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matricula
    ADD CONSTRAINT matricula_id_aluno_fkey FOREIGN KEY (id_aluno) REFERENCES public.aluno(id_aluno);


--
-- TOC entry 4793 (class 2606 OID 24638)
-- Name: matricula matricula_id_disciplina_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matricula
    ADD CONSTRAINT matricula_id_disciplina_fkey FOREIGN KEY (id_disciplina) REFERENCES public.disciplina(id_disciplina);


--
-- TOC entry 4794 (class 2606 OID 24643)
-- Name: matricula matricula_id_turma_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matricula
    ADD CONSTRAINT matricula_id_turma_fkey FOREIGN KEY (id_turma) REFERENCES public.turma(id_turma);


-- Completed on 2026-01-12 10:20:31

--
-- PostgreSQL database dump complete
--

