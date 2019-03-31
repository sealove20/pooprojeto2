async function getUser() {
  try {
    return await axios.get("http://localhost:8090/clientes");
  } catch (error) {
    console.error(error);
  }
}

async function postUser() {
  try {
    return await axios.post("http://localhost:8090/clientes", {
      nome:"joao sampaio",
      idade: 90,
      endereco: "endereco do joao",
      cidade: "cidade do joao"
    });
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
