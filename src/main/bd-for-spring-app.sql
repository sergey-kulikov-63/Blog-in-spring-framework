--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

-- Started on 2023-04-24 13:56:06

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
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
-- TOC entry 209 (class 1259 OID 57558)
-- Name: comments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comments (
    comment_id bigint NOT NULL,
    comment_date date,
    comment_text character varying(255),
    user_name character varying(255),
    post_id bigint,
    user_email character varying(255)
);


ALTER TABLE public.comments OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 57579)
-- Name: comments_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.comments_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comments_seq OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 57565)
-- Name: posts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.posts (
    post_id bigint NOT NULL,
    post_anons character varying(255),
    post_date date,
    post_text character varying,
    post_title character varying(255)
);


ALTER TABLE public.posts OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 57580)
-- Name: posts_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.posts_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.posts_seq OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 57572)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id bigint NOT NULL,
    user_email character varying(255),
    user_name character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 57581)
-- Name: users_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_seq OWNER TO postgres;

--
-- TOC entry 3320 (class 0 OID 57558)
-- Dependencies: 209
-- Data for Name: comments; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3321 (class 0 OID 57565)
-- Dependencies: 210
-- Data for Name: posts; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3322 (class 0 OID 57572)
-- Dependencies: 211
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3331 (class 0 OID 0)
-- Dependencies: 212
-- Name: comments_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.comments_seq', 851, true);


--
-- TOC entry 3332 (class 0 OID 0)
-- Dependencies: 213
-- Name: posts_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.posts_seq', 251, true);


--
-- TOC entry 3333 (class 0 OID 0)
-- Dependencies: 214
-- Name: users_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_seq', 551, true);


--
-- TOC entry 3175 (class 2606 OID 57564)
-- Name: comments comments_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comments
    ADD CONSTRAINT comments_pkey PRIMARY KEY (comment_id);


--
-- TOC entry 3177 (class 2606 OID 57571)
-- Name: posts posts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.posts
    ADD CONSTRAINT posts_pkey PRIMARY KEY (post_id);


--
-- TOC entry 3179 (class 2606 OID 57578)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 3180 (class 2606 OID 65675)
-- Name: comments fkh4c7lvsc298whoyd4w9ta25cr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comments
    ADD CONSTRAINT fkh4c7lvsc298whoyd4w9ta25cr FOREIGN KEY (post_id) REFERENCES public.posts(post_id);


-- Completed on 2023-04-24 13:56:06

--
-- PostgreSQL database dump complete
--

