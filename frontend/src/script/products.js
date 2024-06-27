document.addEventListener("DOMContentLoaded", () => {
  const fetchAndDisplayProducts = () => {
    fetch("http://localhost:8080/products")
      .then(response => response.json())
      .then(data => {
        const tableBody = document.querySelector("#product-table tbody");
        tableBody.innerHTML = "";
        data.sort((a, b) => a.value - b.value).forEach(product => {
          const row = document.createElement("tr");
          row.innerHTML = `
            <td>${product.name}</td>
            <td>$ ${parseFloat(product.value).toFixed(2)}</td>
            <td>
              <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#productModal" 
                data-name="${product.name}" 
                data-description="${product.description}" 
                data-isavailable="${product.isAvailable ? 'Yes' : 'No'}"
                data-value="${parseFloat(product.value).toFixed(2)}"
              >
                Info
              </button>
            </td>
            <td>
              <button type="button" class="btn btn-secondary btn-sm edit-product" 
                data-id="${product.id}"
                data-name="${product.name}" 
                data-description="${product.description}" 
                data-value="${parseFloat(product.value).toFixed(2)}"
                data-isavailable="${product.isAvailable ? 'yes' : 'no'}"
              >
                Edit
              </button>
            </td>
            <td>
              <button type="button" class="btn btn-danger btn-sm delete-product" 
                data-id="${product.id}"
              >
                Delete
              </button>
            </td>
          `;
          tableBody.appendChild(row);
        });

        document.querySelectorAll(".edit-product").forEach(button => {
          button.addEventListener("click", editProduct);
        });

        document.querySelectorAll(".delete-product").forEach(button => {
          button.addEventListener("click", deleteProduct);
        });
      });
  };

  fetchAndDisplayProducts();

  let isEditAction = false;
  let id;

  document.querySelector("#new-product-btn").addEventListener("click", () => {
    const form = document.querySelector("#product-form");
    form.style.display = "flex";
    form.reset();
    isEditAction = false;
  });

  document.querySelector("#close-btn").addEventListener("click", () => {
    document.querySelector("#product-form").style.display = "none";
  });

  document.querySelector("#product-form").addEventListener("submit", e => {
    e.preventDefault();

    const formData = new FormData(e.target);
    const product = {
      name: formData.get("name"),
      description: formData.get("description") || "",
      value: parseFloat(formData.get("value")),
      isAvailable: formData.get("isAvailable") === "yes"
    };

    let url = "http://localhost:8080/products";
    let method = "POST";

    if (isEditAction) {
      url += `/${id}`;
      method = "PUT";
    }

    fetch(url, {
      method: method,
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(product)
    })
      .then(response => response.json())
      .then(() => {
        fetchAndDisplayProducts();
        document.querySelector("#product-form").style.display = "none";
        e.target.reset();
      });
  });

  const editProduct = e => {
    const button = e.target;
    const productName = button.getAttribute("data-name");
    const productDescription = button.getAttribute("data-description");
    const productValue = button.getAttribute("data-value");
    const productIsAvailable = button.getAttribute("data-isavailable");

    document.querySelector("#product-form").style.display = "flex";
    document.querySelector("#name").value = productName;
    document.querySelector("#description").value = productDescription;
    document.querySelector("#value").value = productValue;
    document.querySelector("#isAvailable").value = productIsAvailable;

    isEditAction = true;
    id = button.getAttribute("data-id");
  };

  const deleteProduct = e => {
    const button = e.target;
    const productId = button.getAttribute("data-id");

    fetch(`http://localhost:8080/products/${productId}`, {
      method: "DELETE"
    }).then(() => {
      fetchAndDisplayProducts();
    });
  };

  const productModal = document.getElementById("productModal");
  productModal.addEventListener("show.bs.modal", e => {
    const button = e.relatedTarget;
    const name = button.getAttribute("data-name");
    const description = button.getAttribute("data-description");
    const isAvailable = button.getAttribute("data-isavailable");
    const value = button.getAttribute("data-value");

    document.getElementById("productModalLabel").textContent = name;
    document.getElementById("productDescription").textContent = `Description: ${description}`;
    document.getElementById("productAvailability").textContent = `Available: ${isAvailable}`;
    document.getElementById("productValue").textContent = `Value: $ ${value}`;
  });
});
