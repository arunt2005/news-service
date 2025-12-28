function loadNews() {
    const country = document.getElementById("country").value;
    const newsList = document.getElementById("newsList");

    newsList.innerHTML = "Loading news...";

    fetch(`/api/news?country=${country}`)
        .then(res => res.json())
        .then(data => {
            newsList.innerHTML = "";

            data.articles.forEach(article => {
                const card = document.createElement("div");
                card.className = "news-card";

                card.innerHTML = `
                    <img src="${article.urlToImage || 'https://via.placeholder.com/150'}">
                    <div class="news-content">
                        <h3>${article.title}</h3>
                        <p>${article.description || ''}</p>
                        <a href="${article.url}" target="_blank">Read more →</a>
                    </div>
                `;

                newsList.appendChild(card);
            });
        })
        .catch(() => {
            newsList.innerHTML = "Failed to load news";
        });
}
