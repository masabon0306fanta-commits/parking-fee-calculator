--
-- PostgreSQL database dump
--

\restrict bxJFC3LkK3ll5PeHVg9LYkgrzkxxBOcFWf0I0OsohWnIZn2fxfaYPrExfq83Ckm

-- Dumped from database version 18.3
-- Dumped by pg_dump version 18.3

-- Started on 2026-05-12 15:58:20 JST

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
-- TOC entry 220 (class 1259 OID 16389)
-- Name: Parking; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Parking" (
    id integer NOT NULL,
    name character varying(20) NOT NULL,
    addres character varying NOT NULL,
    fee character varying NOT NULL,
    maxfee character varying,
    entrytime timestamp without time zone
);


ALTER TABLE public."Parking" OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16388)
-- Name: Parking_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Parking_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Parking_id_seq" OWNER TO postgres;

--
-- TOC entry 3827 (class 0 OID 0)
-- Dependencies: 219
-- Name: Parking_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Parking_id_seq" OWNED BY public."Parking".id;


--
-- TOC entry 3670 (class 2604 OID 16392)
-- Name: Parking id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Parking" ALTER COLUMN id SET DEFAULT nextval('public."Parking_id_seq"'::regclass);


--
-- TOC entry 3821 (class 0 OID 16389)
-- Dependencies: 220
-- Data for Name: Parking; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Parking" (id, name, addres, fee, maxfee, entrytime) FROM stdin;
2	第二駐車場	大阪府大阪市	500	3000	2026-05-11 15:20:45.241087
1	第一駐車場	東京都渋谷区	700	5000	2026-05-11 15:47:43.357713
\.


--
-- TOC entry 3828 (class 0 OID 0)
-- Dependencies: 219
-- Name: Parking_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Parking_id_seq"', 1, false);


--
-- TOC entry 3672 (class 2606 OID 16401)
-- Name: Parking Parking_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Parking"
    ADD CONSTRAINT "Parking_pkey" PRIMARY KEY (id);


-- Completed on 2026-05-12 15:58:20 JST

--
-- PostgreSQL database dump complete
--

\unrestrict bxJFC3LkK3ll5PeHVg9LYkgrzkxxBOcFWf0I0OsohWnIZn2fxfaYPrExfq83Ckm

