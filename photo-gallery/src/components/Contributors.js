import React from "react";
import { Link } from "react-router-dom";
import sped_logo from "../assets/sped.png";
import luis_picture from "../assets/luis_correia_gomes.png";
import joao_machado from "../assets/joao_machado.jpg";
import nuno_goncalves from "../assets/nuno_goncalves.jpeg";
import "./Contributors.css";

const Contributors = () => {
  return (
    <div className="contributors">
      <div className="contributor">
        <div className="contributor-image">
          <img src={luis_picture} alt="Portrait of Luís Correia Gomes" />
        </div>
        <div className="contributor-info">
          <h2>Luís Correia Gomes</h2>
          <p>
            My name is Luís Correia Gomes, and at 30 years old, I am in the
            final year of my residency at Instituto Português de Oncologia de
            Lisboa Francisco Gentil in Portugal and a member of the Young
            Portuguese National Endoscopic Committee (SPED). During the early
            stages of my endoscopic training, I encountered difficulties in
            finding a comprehensive endoscopic atlas. This challenge inspired me
            to start collecting endoscopic images from the beginning of my
            career with the goal of creating a valuable repository to assist all
            endoscopists.
          </p>
        </div>
      </div>

      <div className="contributor">
        <div className="contributor-image">
          <img src={sped_logo} alt="SPED Logo" />
        </div>
        <div className="contributor-info">
          <h2>Portuguese Society of Digestive Endoscopy (SPED)</h2>
          <p>
            The Portuguese Society of Digestive Endoscopy (SPED) is a
            scientific, non-profit, and public utility association that brings
            together doctors and other health professionals who practice or are
            interested in digestive endoscopy in Portugal. Founded in 1979, SPED
            aims to:
          </p>
          <ul>
            <li>
              Promote the development of digestive endoscopy in service to the
              health of the Portuguese population;
            </li>
            <li>
              Disseminate updated ideas, knowledge, and research in the field of
              digestive endoscopy; Stimulate research in digestive endoscopy;
            </li>
            <li>
              Promote national and international contacts and exchanges among
              various professionals involved in digestive endoscopy;
            </li>
            <li>
              Develop educational activities leading to the training and
              improvement of doctors and other technicians in digestive
              endoscopy;
            </li>
            <li>
              Contribute to the establishment of training and practice standards
              in digestive endoscopy.
            </li>
          </ul>
          <p>
            SPED is affiliated with the European Society of Gastrointestinal
            Endoscopy and the World Endoscopy Organization. This atlas was
            created during the mandate of Prof. Susana Lopes in the biennium
            2023-2025, reflecting SPED's commitment to fostering educational
            resources and enhancing the practice of digestive endoscopy.
          </p>
        </div>
      </div>

      <div className="contributor">
        <div className="contributor-image">
          <img src={joao_machado} alt="Portrait of João Machado" />
        </div>
        <div className="contributor-info">
          <h2>João Machado</h2>
          <p>
            My name is João Machado, and I am 31 years old. I spent seven years
            in the Portuguese Army, where I worked as a radio operator and
            armored personnel carrier driver. At the end of my military career,
            I began my Bachelor's degree in Software Engineering at Instituto
            Superior de Engenharia do Porto (ISEP), attending night school.
            After completing my Bachelor's degree, I continued my studies with a
            Master's degree in Software Engineering at ISEP.
          </p>
          <p>
            Since finishing my Bachelor's, I have been working as a backend
            software developer. I am currently employed at Blip, and I have
            accumulated three years of experience in the software development
            field. In my spare time, I enjoy working on side projects to acquire
            new knowledge on different technologies.
          </p>
        </div>
      </div>

      <div className="contributor">
        <div className="contributor-image">
          <img src={nuno_goncalves} alt="Portrait of Nuno Goncalves" />
        </div>
        <div className="contributor-info">
          <h2>Nuno Gonçalves</h2>
          <p>
            My name is Nuno Gonçalves, and since my first steps in
            Gastroenterology, I’ve found wonder and passion about digestive
            endoscopy. I’m currently in my second year of residency at Instituto
            Português de Oncologia do Porto Francisco Gentil in Portugal and I’m
            eager to learn, research, and enhance my technical and scientific
            knowledge in digestive endoscopy. It never ceases to impress me how
            technology harmoniously collide in digestive endoscopy. It's
            definitely hard to keep up with all the information and still
            provide simple, intelligible and comprehensive information to us,
            beginner trainees. “ScopeView” seems to be the key to help the
            trainees to fill the gap of an endoscopic atlas easily accessible
            and an educational and interactive resource on endoscopic imaging.
            It will hopefully be consulted and updated as a common interest for
            the entire endoscopic community, which I’m honoured to be part of.
          </p>
        </div>
      </div>

      <div className="back-button-container">
        <Link to="/" className="back-button">
          Go Back to Home
        </Link>
      </div>
    </div>
  );
};

export default Contributors;
