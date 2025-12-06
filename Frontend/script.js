const API_URL = "http://localhost:8080/auth";

async function registerUser() {
    const data = {
        username: document.getElementById("reg-username").value,
        password: document.getElementById("reg-password").value
    };

    const res = await fetch(`${API_URL}/register`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    });

    document.getElementById("reg-response").innerText =
        await res.text();
}

async function login() {
    const data = {
        username: document.getElementById("login-username").value,
        password: document.getElementById("login-password").value
    };

    const res = await fetch(`${API_URL}/login`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    });

    const json = await res.json();

    document.getElementById("login-response").innerText =
        JSON.stringify(json, null, 2);
}

async function validateToken() {
    const token = document.getElementById("validate-token").value;

    const res = await fetch(`${API_URL}/validate`, {
        method: "POST",
        headers: {
            "Authorization": `Bearer ${token}`
        }
    });

    document.getElementById("validate-response").innerText =
        await res.text();
}
