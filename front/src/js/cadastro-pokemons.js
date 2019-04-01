class Pokemon {
  constructor(nome, cp, hp, doce, tipo) {
    this.nome = nome;
    this.cp = cp;
    this.hp = hp;
    this.doce = doce;
    this.tipo = tipo;
  }
}

async function postUser(poke) {
  try {
    return await axios.post("http://localhost:8090/pokemons", poke);
  } catch (error) {
    console.error(error);
  }
}

const nome = document.querySelector("#nome");
const cp = document.querySelector("#cp");
const hp = document.querySelector("#hp");
const doce = document.querySelector("#doce");
const tipo = document.querySelector("#tipo");
const btn = document.querySelector("#btn");
btn.addEventListener("click", () => {
  const poke = new Pokemon(
    nome.value,
    cp.value,
    hp.value,
    doce.value,
    tipo.value
  );
  postUser(poke);
});
