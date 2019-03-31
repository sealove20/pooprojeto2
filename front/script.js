class Pokemon {
  constructor(nome, cp, hp, doce, tipo) {
    this.nome = nome;
    this.cp = cp;
    this.hp = hp;
    this.doce = doce;
    this.tipo = tipo;
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

async function getUser() {
  try {
    return await axios.get("http://localhost:8090/pokemons");
  } catch (error) {
    console.error(error);
  }
}

async function postUser(poke) {
  try {
    return await axios.post("http://localhost:8090/pokemons", poke);
  } catch (error) {
    console.error(error);
  }
}

let dados = [];
async function render() {
  try {
    const resp = await getUser();

    resp.data.forEach(element => {
      const { id, nome, endereco, cidade, idade } = element;
      dados.push({
        id,
        nome,
        endereco,
        cidade,
        idade
      });
    });

    console.log(dados);
    const main = document.querySelector("#main");
    dados.forEach(el => {
      let titleEl = document.createElement("p");
      titleEl.appendChild(document.createTextNode(el.nome));
      main.appendChild(titleEl);
    });
  } catch (error) {
    console.error(error);
  }
}

render();
