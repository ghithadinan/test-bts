PGDMP     :                
    {            test_db_bts    14.5    14.5                 0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    44766    test_db_bts    DATABASE     o   CREATE DATABASE test_db_bts WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE test_db_bts;
                postgres    false            �            1255    44781    uuid_generate_v1()    FUNCTION     }   CREATE FUNCTION public.uuid_generate_v1() RETURNS uuid
    LANGUAGE c STRICT
    AS '$libdir/uuid-ossp', 'uuid_generate_v1';
 )   DROP FUNCTION public.uuid_generate_v1();
       public          postgres    false            �            1259    44787 	   checklist    TABLE     �   CREATE TABLE public.checklist (
    id character varying(255) DEFAULT public.uuid_generate_v1() NOT NULL,
    name character varying(255)
);
    DROP TABLE public.checklist;
       public         heap    postgres    false    212            �            1259    44804    checklist_item    TABLE     �   CREATE TABLE public.checklist_item (
    id character varying(255) DEFAULT public.uuid_generate_v1() NOT NULL,
    item_name character varying(255),
    checklist_id character varying(255),
    checked boolean DEFAULT false
);
 "   DROP TABLE public.checklist_item;
       public         heap    postgres    false    212            �            1259    44768    users    TABLE     �   CREATE TABLE public.users (
    id character varying(255) DEFAULT public.uuid_generate_v1() NOT NULL,
    username character varying(255),
    password character varying(255),
    email character varying(255)
);
    DROP TABLE public.users;
       public         heap    postgres    false    212            �          0    44787 	   checklist 
   TABLE DATA           -   COPY public.checklist (id, name) FROM stdin;
    public          postgres    false    210          �          0    44804    checklist_item 
   TABLE DATA           N   COPY public.checklist_item (id, item_name, checklist_id, checked) FROM stdin;
    public          postgres    false    211   F       �          0    44768    users 
   TABLE DATA           >   COPY public.users (id, username, password, email) FROM stdin;
    public          postgres    false    209   �       o           2606    44811 #   checklist_item checklist_copy1_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.checklist_item
    ADD CONSTRAINT checklist_copy1_pkey PRIMARY KEY (id);
 M   ALTER TABLE ONLY public.checklist_item DROP CONSTRAINT checklist_copy1_pkey;
       public            postgres    false    211            m           2606    44797    checklist checklist_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.checklist
    ADD CONSTRAINT checklist_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.checklist DROP CONSTRAINT checklist_pkey;
       public            postgres    false    210            i           2606    44776    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    209            k           2606    44786    users users_username_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);
 B   ALTER TABLE ONLY public.users DROP CONSTRAINT users_username_key;
       public            postgres    false    209            �   4   x�K3O�4�0NյH27�54LM�M473�55�0�4�0��HK�4����� ��	�      �   x   x��̱1 ��ޅ���� <FJ�U���U��O�lJB�yA�{��0�E!�<
b�;.+�hή�-;�43�ጠe諗�w�O;��4u��/qفf�60]��n������Qk�Sa@�      �   �   x�U��N�@ �3<��a��I��Ж؄�x���,�R�>�cR�����BW	 Jy��I�K�kNpE��T�뽀@���\�}G��^!��p�m:Ml�O�_�B]����;֧���&�롷�Ϧ׆�{��*�B��b�TH2���$�Z���/����-Ci�7鉛~��ݧ��逇����4�9�l������-�}�KQ�     