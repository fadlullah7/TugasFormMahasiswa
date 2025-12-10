--
-- PostgreSQL database dump
--

\restrict GS7THWB9aRL8uf9641OyqRmJ8ho9cj1t0lKpYXkuE0nwrPZoejuSZxB9d3vh300

-- Dumped from database version 17.6
-- Dumped by pg_dump version 17.6

-- Started on 2025-12-10 23:42:10

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 220 (class 1259 OID 16745)
-- Name: jenis_mahasiswa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jenis_mahasiswa (
    id integer NOT NULL,
    nama_jenis character varying(30) NOT NULL
);


ALTER TABLE public.jenis_mahasiswa OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16744)
-- Name: jenis_mahasiswa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.jenis_mahasiswa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.jenis_mahasiswa_id_seq OWNER TO postgres;

--
-- TOC entry 4909 (class 0 OID 0)
-- Dependencies: 219
-- Name: jenis_mahasiswa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.jenis_mahasiswa_id_seq OWNED BY public.jenis_mahasiswa.id;


--
-- TOC entry 218 (class 1259 OID 16737)
-- Name: mahasiswa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mahasiswa (
    id integer NOT NULL,
    nim character varying(20) NOT NULL,
    nama character varying(100) NOT NULL,
    tahun_masuk integer DEFAULT 2024 NOT NULL,
    jenis_id integer,
    sks integer,
    biaya double precision
);


ALTER TABLE public.mahasiswa OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16736)
-- Name: mahasiswa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.mahasiswa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.mahasiswa_id_seq OWNER TO postgres;

--
-- TOC entry 4910 (class 0 OID 0)
-- Dependencies: 217
-- Name: mahasiswa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.mahasiswa_id_seq OWNED BY public.mahasiswa.id;


--
-- TOC entry 4749 (class 2604 OID 16748)
-- Name: jenis_mahasiswa id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jenis_mahasiswa ALTER COLUMN id SET DEFAULT nextval('public.jenis_mahasiswa_id_seq'::regclass);


--
-- TOC entry 4747 (class 2604 OID 16740)
-- Name: mahasiswa id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mahasiswa ALTER COLUMN id SET DEFAULT nextval('public.mahasiswa_id_seq'::regclass);


--
-- TOC entry 4903 (class 0 OID 16745)
-- Dependencies: 220
-- Data for Name: jenis_mahasiswa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.jenis_mahasiswa (id, nama_jenis) FROM stdin;
1	Reguler
2	Beasiswa
3	Internasional
\.


--
-- TOC entry 4901 (class 0 OID 16737)
-- Dependencies: 218
-- Data for Name: mahasiswa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mahasiswa (id, nim, nama, tahun_masuk, jenis_id, sks, biaya) FROM stdin;
22	9292	zami	2024	1	3	450000
23	0202	haris	2024	2	3	225000
24	2424	sharfina	2024	3	3	5900000
26	3030	dina	2024	1	5	750000
\.


--
-- TOC entry 4911 (class 0 OID 0)
-- Dependencies: 219
-- Name: jenis_mahasiswa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.jenis_mahasiswa_id_seq', 3, true);


--
-- TOC entry 4912 (class 0 OID 0)
-- Dependencies: 217
-- Name: mahasiswa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.mahasiswa_id_seq', 26, true);


--
-- TOC entry 4753 (class 2606 OID 16750)
-- Name: jenis_mahasiswa jenis_mahasiswa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jenis_mahasiswa
    ADD CONSTRAINT jenis_mahasiswa_pkey PRIMARY KEY (id);


--
-- TOC entry 4751 (class 2606 OID 16742)
-- Name: mahasiswa mahasiswa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mahasiswa
    ADD CONSTRAINT mahasiswa_pkey PRIMARY KEY (id);


--
-- TOC entry 4754 (class 2606 OID 16752)
-- Name: mahasiswa fk_jenis; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mahasiswa
    ADD CONSTRAINT fk_jenis FOREIGN KEY (jenis_id) REFERENCES public.jenis_mahasiswa(id);


-- Completed on 2025-12-10 23:42:11

--
-- PostgreSQL database dump complete
--

\unrestrict GS7THWB9aRL8uf9641OyqRmJ8ho9cj1t0lKpYXkuE0nwrPZoejuSZxB9d3vh300

