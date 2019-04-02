class Treinador {
  constructor(nome, nivel, time) {
    this.nome = nome;
    this.nivel = nivel;
    this.time = time;
  }
}

async function postUser(trein) {
  try {
    return await axios.post("http://localhost:8090/treinadores", trein);
  } catch (error) {
    console.error(error);
  }
}

const nome = document.querySelector("#nome");
const nivel = document.querySelector("#nivel");
const time = document.querySelector("#time");
btn.addEventListener("click", () => {
  const trein = new Treinador(
    nome.value,
    nivel.value,
    time.value
  );
  postUser(trein);
});
